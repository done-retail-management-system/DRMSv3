<?php
// required headers
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
 
// include database and object files
include_once '../config/database.php';
include_once '../objects/supplier.php';
 
// get database connection
$database = new database();
$db = $database->getConnection();
 
// prepare product object
$supplier = new supplier($db);
 
// get id of product to be edited
$data = json_decode(file_get_contents("php://input"));
 
// set ID property of product to be edited
$supplier->supp_id = $data->supp_id;
 
// set product property values
$supplier->supplier_name = $data->supplier_name;
$supplier->category = $data->category;
$supplier->address = $data->address;
$supplier->contact_number = $data->contact_number;
$supplier->contact_person = $data->contact_person;

 
// update the product
if($supplier->update()){
 
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