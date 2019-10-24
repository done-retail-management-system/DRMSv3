<?php

header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");

include_once '../config/database.php';
include_once '../objects/product_warehouse.php';

$database = new database();
$db = $database->getConnection();

$product_warehouse = new product_warehouse($db);

$stmt = $product_warehouse->read();
$num = $stmt->rowCount();
 

if($num>0){
 
    
    $products_arr=array();
    $products_arr["records"]=array();
 
    //
    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)){
        
        extract($row);
 
        $product_item=array(
            "barcode" => $barcode,
            "quantity" => $quantity,
            "category" => $category,
            "type" => $type,
            "weight" => $weight,
            "manufacture name" => $manufacture_name,
            "manufacture date" => $manufacture_date,
            "expiry date" => $expiry_date,
            "location" => $location,
            "fragile" => $fragile,
            "perishable" => $perishable
        );
 
        array_push($products_arr["records"], $product_item);
    }
 
    // set response code - 200 OK
    http_response_code(200);
 
    // show products data in json format
    echo json_encode($products_arr);
}
 
else{
 
    // set response code - 404 Not found
    http_response_code(404);
 
    // tell the user no products found
    echo json_encode(
        array("message" => "No products found.")
    );
}