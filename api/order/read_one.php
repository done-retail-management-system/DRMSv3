<?php
// required headers
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: access");
header("Access-Control-Allow-Methods: GET");
header("Access-Control-Allow-Credentials: true");
header('Content-Type: application/json');
 
// include database and object files
include_once '../config/database.php';
include_once '../objects/order.php';
 
// get database connection
$database = new database();
$db = $database->getConnection();
 
// prepare product object
$order = new order($db);
 
// set ID property of record to read
$order->order_id = isset($_GET['order_id']) ? $_GET['order_id'] : die();
 
// read the details of product to be edited
$order->readOne();
 
if($order->manufacture_name!=null){
    // create array
    $product_arr = array(
        "order_id" =>  $order->order_id,
        "shop_id" => $order->shop_id,
        "product_id" => $order->product_id,
        "date_of_order" => $order->date_of_order,
        "quantity" => $order->quantity
       
    );
 
    // set response code - 200 OK
    http_response_code(200);
 
    // make it json format
    echo json_encode($product_arr);
}
 
else{
    // set response code - 404 Not found
    http_response_code(404);
 
    // tell the user product does not exist
    echo json_encode(array("message" => "Product does not exist."));
}
?>