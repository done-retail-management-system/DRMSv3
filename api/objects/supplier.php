<?php
class supplier{
	private $conn;
	private $table_name = "supplier";

	public $supp_id;
	public $supplier_name;
	public $category;
	public $address;
	public $contact_number;
	public $contact_person;


	public function __construct($db){
		$this->conn = $db;
	}

	function read(){
 
    // select all query
    $query = "SELECT * FROM `supplier`";
 
    // prepare query statement
    $stmt = $this->conn->prepare($query);
 
    // execute query
    $stmt->execute();
 
    return $stmt;
	}

	// create product

function update(){
 
    // update query
    $query = "UPDATE
                " . $this->table_name . "
            SET
                supp_id=:supp_id, supplier_name=:supplier_name, category=:category, address=:address, contact_number=:contact_number, contact_person=:contact_person
            WHERE
                supp_id=:supp_id";
 
    // prepare query statement
    $stmt = $this->conn->prepare($query);
 
    // sanitize
    $this->supp_id=htmlspecialchars(strip_tags($this->supp_id));
    $this->supplier_name=htmlspecialchars(strip_tags($this->supplier_name));
    $this->category=htmlspecialchars(strip_tags($this->category));
    $this->address=htmlspecialchars(strip_tags($this->address));
    $this->contact_number=htmlspecialchars(strip_tags($this->contact_number));
    $this->contact_person=htmlspecialchars(strip_tags($this->contact_person));
   
 
    // bind new values
    $stmt->bindParam(":supp_id", $this->supp_id);
    $stmt->bindParam(":supplier_name", $this->supplier_name);
    $stmt->bindParam(":category", $this->category);
    $stmt->bindParam(":address", $this->address);
    $stmt->bindParam(":contact_number", $this->contact_number);
    $stmt->bindParam(":contact_person", $this->contact_person);
 
    // execute the query
    if($stmt->execute()){
        return true;
    }
 
    return false;
}

function delete(){
 
    // delete query
    $query = "DELETE FROM `supplier` WHERE supp_id = ?";;
 
    // prepare query
    $stmt = $this->conn->prepare($query);
 
    // sanitize
    $this->supp_id=htmlspecialchars(strip_tags($this->supp_id));
 
    // bind id of record to delete
    $stmt->bindParam(1, $this->supp_id);
 
    // execute query
    if($stmt->execute()){
        return true;
    }
 
    return false;
     
}

}

?>