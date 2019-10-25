<?php
// required headers
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: access");
header("Access-Control-Allow-Methods: GET");
header("Access-Control-Allow-Credentials: true");
header('Content-Type: application/json');
 
// include database and object files
include_once '../config/database.php';
include_once '../objects/supplier.php';
 
// get database connection
$database = new database();
$db = $database->getConnection();
 
// prepare product object
$supplier = new supplier($db);
 
// set ID property of record to read
$supplier->supp_id = isset($_GET['supp_id']) ? $_GET['supp_id'] : die();
 
// read the details of product to be edited
$supplier->readOne();
 
if($supplier->manufacture_name!=null){
    // create array
    $product_arr = array(
        "supp_id" =>  $supplier->supp_id,
        "supplier_name" => $supplier->supplier_name,
        "category" => $supplier->category,
        "address" => $supplier->address,
        "contact_number" => $supplier->contact_number,
        "contact_person" => $supplier->contact_person

        
 
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