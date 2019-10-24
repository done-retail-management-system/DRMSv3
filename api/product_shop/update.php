<?php
// required headers
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
 
// include database and object files
include_once '../config/database.php';
include_once '../objects/product_shop.php';
 
// get database connection
$database = new database();
$db = $database->getConnection();
 
// prepare product object
$product_shop = new product_shop($db);
 
// get id of product to be edited
$data = json_decode(file_get_contents("php://input"));
 
// set ID property of product to be edited
$product_shop->barcode = $data->barcode;

// set product property values
$product_shop->name = $data->name;
$product_shop->category = $data->category;
$product_shop->type = $data->type;
$product_shop->weight = $data->weight;
$product_shop->manufacture_date = $data->manufacture_date;
$product_shop->expiray_date = $data->expiray_date;
$product_shop->perishable = $data->perishable;
$product_shop->fragile = $data->fragile;
$product_shop->price = $data->price;


 
// update the product
if($product_shop->update()){
 
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