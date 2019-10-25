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
include_once '../objects/product_warehouse.php';
 
$database = new database();
$db = $database->getConnection();
 
$product_warehouse = new product_warehouse($db);
 
// get posted data
$data = json_decode(file_get_contents("php://input"));
 
// make sure data is not empty
if(
    !empty($data->barcode)&& 
    !empty($data->quantity) &&
    !empty($data->category) &&
    !empty($data->type)&&
    !empty($data->weight)&&
    !empty($data->manufacture_name)&&
    !empty($data->manufacture_date)&&
    !empty($data->expiry_date)&&
    !empty($data->location)
   //!empty($data->fragile)&&
    //!empty($data->perishable)
){
 
    // set product property values
    $product_warehouse->barcode = $data->barcode;
    $product_warehouse->quantity = $data->quantity;
    $product_warehouse->category = $data->category;
    $product_warehouse->type = $data->type;
    $product_warehouse->weight = $data->weight;
    $product_warehouse->manufacture_name = $data->manufacture_name;
    $product_warehouse->manufacture_date = date('Y-m-d H:i:s');
    $product_warehouse->expiry_date = date('Y-m-d H:i:s');
    $product_warehouse->location = $data->location;
    $product_warehouse->fragile = $data->fragile;
    $product_warehouse->perishable = $data->perishable;
 
    // create the product
    if($product_warehouse->create()){
 
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