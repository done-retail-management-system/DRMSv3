<?php
class shelf{
	private $conn;
	private $table_name = "shelf";

	public $barcode_shelf;
	

	public function __construct($db){
		$this->conn = $db;
	}

	function read(){
 
    // select all query
    $query = "SELECT * FROM `shelf`";
 
    // prepare query statement
    $stmt = $this->conn->prepare($query);
 
    // execute query
    $stmt->execute();
 
    return $stmt;
	}


    function readOne(){
 
    // query to read single record
    $query = "SELECT * FROM `shelf` WHERE barcode_shelf = ?";
 
    // prepare query statement
    $stmt = $this->conn->prepare( $query );
 
    // bind id of product to be updated
    $stmt->bindParam(1, $this->barcode_shelf);
 
    // execute query
    $stmt->execute();
 
    // get retrieved row
    $row = $stmt->fetch(PDO::FETCH_ASSOC);
 
    // set values to object properties
   
    $this->barcode_shelf = $row['barcode_shelf'];
    
    }



    function delete(){
 
    // delete query
    $query = "DELETE FROM `shelf` WHERE barcode_shelf = ?";;
 
    // prepare query
    $stmt = $this->conn->prepare($query);
 
    // sanitize
    $this->barcode_shelf=htmlspecialchars(strip_tags($this->barcode_shelf));
 
    // bind id of record to delete
    $stmt->bindParam(1, $this->barcode_shelf);
 
    // execute query
    if($stmt->execute()){
        return true;
    }
 
    return false;
     
}

}

?>

