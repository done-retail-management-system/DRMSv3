<?php
class shop{
	private $conn;
	private $table_name = "shop";

	public $shop_id;
	public $shop_name;
	public $contact_number;
	public $contact_person;
	public $address;
	

	public function __construct($db){
		$this->conn = $db;
	}

	function read(){
 
    // select all query
    $query = "SELECT * FROM `shop`";
 
    // prepare query statement
    $stmt = $this->conn->prepare($query);
 
    // execute query
    $stmt->execute();
 
    return $stmt;
	}



function update(){
 
    // update query
    $query = "UPDATE
                " . $this->table_name . "
            SET
                shop_id=:shop_id, shop_name=:shop_name, contact_number=:contact_number, contact_person=:contact_person, address=:address
            WHERE
                shop_id=:shop_id";
 
    // prepare query statement
    $stmt = $this->conn->prepare($query);
 
    // sanitize
    $this->shop_id=htmlspecialchars(strip_tags($this->shop_id));
    $this->shop_name=htmlspecialchars(strip_tags($this->shop_name));
    $this->contact_number=htmlspecialchars(strip_tags($this->contact_number));
    $this->contact_person=htmlspecialchars(strip_tags($this->contact_person));
    $this->address=htmlspecialchars(strip_tags($this->address));
   
 
    // bind new values
    $stmt->bindParam(":shop_id", $this->shop_id);
    $stmt->bindParam(":shop_name", $this->shop_name);
    $stmt->bindParam(":contact_number", $this->contact_number);
    $stmt->bindParam(":contact_person", $this->contact_person);
    $stmt->bindParam(":address", $this->address);
 
    // execute the query
    if($stmt->execute()){
        return true;
    }
 
    return false;
}

function readOne(){
 
    // query to read single record
    $query = "SELECT * FROM `shop` WHERE shop_id = ?";
 
    // prepare query statement
    $stmt = $this->conn->prepare( $query );
 
    // bind id of product to be updated
    $stmt->bindParam(1, $this->shop_id);
 
    // execute query
    $stmt->execute();
 
    // get retrieved row
    $row = $stmt->fetch(PDO::FETCH_ASSOC);
 
    // set values to object properties
    $this->shop_id = $row['shop_id'];
    $this->shop_name = $row['shop_name'];
    $this->contact_number = $row['contact_number'];
    $this->contact_person = $row['contact_person'];
    $this->address = $row['address'];
}


function delete(){
 
    // delete query
    $query = "DELETE FROM `shop` WHERE shop_id = ?";;
 
    // prepare query
    $stmt = $this->conn->prepare($query);
 
    // sanitize
    $this->shop_id=htmlspecialchars(strip_tags($this->shop_id));
 
    // bind id of record to delete
    $stmt->bindParam(1, $this->shop_id);
 
    // execute query
    if($stmt->execute()){
        return true;
    }
 
    return false;
     
}

}

?>