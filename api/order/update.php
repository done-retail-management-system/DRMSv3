<?php
// required headers
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
 
// include database and object files
include_once '../config/database.php';
include_once '../objects/order.php';
 
// get database connection
$database = new database();
$db = $database->getConnection();
 
// prepare product object
$order = new order($db);
 
// get id of product to be edited
$data = json_decode(file_get_contents("php://input"));
 
// set ID property of product to be edited
$order->barcode = $data->barcode;
 
// set product property values
$order->quantity = $data->quantity;
$order->order_id = $data->order_id;
$order->shop_id = $data->shop_id;
$order->product_id = $data->product_id;
$order->date_of_order = $data->date_of_order;

// update the product
if($order->update()){
 
    // set response code - 200 ok
    http_response_code(200);
 
    // tell the user
    echo json_encode(array("message" => "Product was updated."));
}
 
// if unable to update the product, tell the user
else{
 
    // set response code - 503 service unavailable
    http_response_code(503);
 
    // tell the user
    echo json_encode(array("message" => "Unable to update product."));
}
?>