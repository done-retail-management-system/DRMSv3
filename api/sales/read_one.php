<?php
// required headers
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: access");
header("Access-Control-Allow-Methods: GET");
header("Access-Control-Allow-Credentials: true");
header('Content-Type: application/json');
 
// include database and object files
include_once '../config/database.php';
include_once '../objects/sales.php';
 
// get database connection
$database = new database();
$db = $database->getConnection();
 
// prepare product object
$sales = new sales($db);
 
// set ID property of record to read
$sales->sales_id = isset($_GET['sales_id']) ? $_GET['sales_id'] : die();
 
// read the details of product to be edited
$sales->readOne();
 
if($sales->sales_id!=null){
    // create array
    $product_arr = array(
        "barcode" =>  $sales->barcode,
        "date" => $sales->date,
        "transaction_type" => $sales->transaction_type,
        "amount" => $sales->amount
        
       
 
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