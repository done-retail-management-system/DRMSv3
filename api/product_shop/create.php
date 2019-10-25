<?php
// required headers
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
 
// get database connection
include_once '../config/database.php';
 
// instantiate product object
include_once '../objects/product_shop.php';
 
$database = new database();
$db = $database->getConnection();
 
$product_shop = new product_shop($db);
 
// get posted data
$data = json_decode(file_get_contents("php://input"));
 
// make sure data is not empty
if(
    !empty($data->barcode) &&
    !empty($data->name) &&
    !empty($data->category) &&
    !empty($data->type)&&
    !empty($data->weight)&&
    !empty($data->manufacture_date)&&
    !empty($data->expiray_date)&&
    !empty($data->price)

){
 
    // set product property values
    $product_shop->barcode = $data->barcode;
    $product_shop->name = $data->name;
    $product_shop->category = $data->category;
    $product_shop->type = $data->type;
    $product_shop->weight = $data->weight;
    $product_shop->manufacture_date = date('Y-m-d H:i:s');
    $product_shop->expiray_date = date('Y-m-d H:i:s');
    $product_shop->price = $data->price;
 
    // create the product
    if($product_shop->create()){
 
        // set response code - 201 created
        http_response_code(201);
 
        // tell the user
        echo json_encode(array("message" => "Product was created."));
    }
 
    // if unable to create the product, tell the user
    else{
 
        // set response code - 503 service unavailable
        http_response_code(503);
 
        // tell the user
        echo json_encode(array("message" => "Unable to create product."));
    }
}
 
// tell the user data is incomplete
else{
 
    // set response code - 400 bad request
    http_response_code(400);
 
    // tell the user
    echo json_encode(array("message" => "Unable to create product. Data is incomplete."));
}
?>