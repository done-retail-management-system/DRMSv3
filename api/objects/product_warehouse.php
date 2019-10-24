<?php
class product_warehouse{
	private $conn;
	private $table_name = "product_warehouse";

	public $barcode;
	public $quantity;
	public $category;
	public $type;
	public $weight;
	public $manufacture_name;
	public $manufacture_date;
	public $expiry_date;
	public $location;
	public $fragile;
	public $perishable;

	public function __construct($db){
		$this->conn = $db;
	}

	function read(){
 
    // select all query
    $query = "SELECT * FROM `product_warehouse`";
 
    // prepare query statement
    $stmt = $this->conn->prepare($query);
 
    // execute query
    $stmt->execute();
 
    return $stmt;
	}

	// create product
function create(){
 
    // query to insert record
    $query = "INSERT INTO
                " . $this->table_name . "
            SET
                barcode=:barcode, quantity=:quantity, category=:category, type=:type, weight=:weight, manufacture_name=:manufacture_name, manufacture_date=:manufacture_date, expiry_date=:expiry_date, location=:location, fragile=:fragile, perishable=:perishable";
 
    // prepare query
    $stmt = $this->conn->prepare($query);
 
    // sanitize
    $this->barcode=htmlspecialchars(strip_tags($this->barcode));
    $this->quantity=htmlspecialchars(strip_tags($this->quantity));
    $this->category=htmlspecialchars(strip_tags($this->category));
    $this->type=htmlspecialchars(strip_tags($this->type));
    $this->weight=htmlspecialchars(strip_tags($this->weight));
    $this->manufacture_name=htmlspecialchars(strip_tags($this->manufacture_name));
    $this->manufacture_date=htmlspecialchars(strip_tags($this->manufacture_date));
    $this->expiry_date=htmlspecialchars(strip_tags($this->expiry_date));
    $this->location=htmlspecialchars(strip_tags($this->location));
    $this->fragile=htmlspecialchars(strip_tags($this->fragile));
    $this->perishable=htmlspecialchars(strip_tags($this->perishable));
 
    // bind values
    $stmt->bindParam(":barcode", $this->barcode);
    $stmt->bindParam(":quantity", $this->quantity);
    $stmt->bindParam(":category", $this->category);
    $stmt->bindParam(":type", $this->type);
    $stmt->bindParam(":weight", $this->weight);
    $stmt->bindParam(":manufacture_name", $this->manufacture_name);
    $stmt->bindParam(":manufacture_date", $this->manufacture_date);
    $stmt->bindParam(":expiry_date", $this->expiry_date);
    $stmt->bindParam(":location", $this->location);
    $stmt->bindParam(":fragile", $this->fragile);
    $stmt->bindParam(":perishable", $this->perishable);
 
    // execute query
    if($stmt->execute()){
        return true;
    }
 
    return false;
     
	}

	function readOne(){
 
    // query to read single record
    $query = "SELECT `barcode`, `quantity`, `category`, `weight`, `manufacture_name`, `location` FROM `product_warehouse` WHERE barcode = ?";
 
    // prepare query statement
    $stmt = $this->conn->prepare( $query );
 
    // bind id of product to be updated
    $stmt->bindParam(1, $this->barcode);
 
    // execute query
    $stmt->execute();
 
    // get retrieved row
    $row = $stmt->fetch(PDO::FETCH_ASSOC);
 
    // set values to object properties
    $this->manufacture_name = $row['manufacture_name'];
    $this->barcode = $row['barcode'];
    $this->quantity = $row['quantity'];
    $this->category = $row['category'];
    $this->weight = $row['weight'];
    $this->location = $row['location'];
}

function update(){
 
    // update query
    $query = "UPDATE
                " . $this->table_name . "
            SET
                barcode=:barcode, quantity=:quantity, category=:category, type=:type, weight=:weight, manufacture_name=:manufacture_name, manufacture_date=:manufacture_date, expiry_date=:expiry_date, location=:location, fragile=:fragile, perishable=:perishable
            WHERE
                barcode = :barcode";
 
    // prepare query statement
    $stmt = $this->conn->prepare($query);
 
    // sanitize
    $this->barcode=htmlspecialchars(strip_tags($this->barcode));
    $this->quantity=htmlspecialchars(strip_tags($this->quantity));
    $this->category=htmlspecialchars(strip_tags($this->category));
    $this->type=htmlspecialchars(strip_tags($this->type));
    $this->weight=htmlspecialchars(strip_tags($this->weight));
    $this->manufacture_name=htmlspecialchars(strip_tags($this->manufacture_name));
    $this->manufacture_date=htmlspecialchars(strip_tags($this->manufacture_date));
    $this->expiry_date=htmlspecialchars(strip_tags($this->expiry_date));
    $this->location=htmlspecialchars(strip_tags($this->location));
    $this->fragile=htmlspecialchars(strip_tags($this->fragile));
    $this->perishable=htmlspecialchars(strip_tags($this->perishable));
 
    // bind new values
    $stmt->bindParam(":barcode", $this->barcode);
    $stmt->bindParam(":quantity", $this->quantity);
    $stmt->bindParam(":category", $this->category);
    $stmt->bindParam(":type", $this->type);
    $stmt->bindParam(":weight", $this->weight);
    $stmt->bindParam(":manufacture_name", $this->manufacture_name);
    $stmt->bindParam(":manufacture_date", $this->manufacture_date);
    $stmt->bindParam(":expiry_date", $this->expiry_date);
    $stmt->bindParam(":location", $this->location);
    $stmt->bindParam(":fragile", $this->fragile);
    $stmt->bindParam(":perishable", $this->perishable);
 
    // execute the query
    if($stmt->execute()){
        return true;
    }
 
    return false;
}

function delete(){
 
    // delete query
    $query = "DELETE FROM `product_warehouse` WHERE barcode = ?";;
 
    // prepare query
    $stmt = $this->conn->prepare($query);
 
    // sanitize
    $this->barcode=htmlspecialchars(strip_tags($this->barcode));
 
    // bind id of record to delete
    $stmt->bindParam(1, $this->barcode);
 
    // execute query
    if($stmt->execute()){
        return true;
    }
 
    return false;
     
}

}

?>

