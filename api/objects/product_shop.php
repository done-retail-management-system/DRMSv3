<?php
class product_shop{
	private $conn;
	private $table_name = "product_shop";

	public $barcode;
	public $name;
	public $category;
	public $type;
	public $weight;
	public $manufacture_date;
	public $expiray_date;
	public $fragile;
	public $perishable;
    public $price;

	public function __construct($db){
		$this->conn = $db;
	}

	function read(){
 
    // select all query
    $query = "SELECT * FROM `product_shop`";
 
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
                barcode=:barcode, name=:name, category=:category, type=:type, weight=:weight, manufacture_date=:manufacture_date, expiray_date=:expiray_date, fragile=:fragile, perishable=:perishable, price=:price";
 
    // prepare query
    $stmt = $this->conn->prepare($query);
 
    // sanitize
    $this->barcode=htmlspecialchars(strip_tags($this->barcode));
    $this->name=htmlspecialchars(strip_tags($this->name));
    $this->category=htmlspecialchars(strip_tags($this->category));
    $this->type=htmlspecialchars(strip_tags($this->type));
    $this->weight=htmlspecialchars(strip_tags($this->weight));
    $this->manufacture_date=htmlspecialchars(strip_tags($this->manufacture_date));
    $this->expiray_date=htmlspecialchars(strip_tags($this->expiray_date));
    $this->fragile=htmlspecialchars(strip_tags($this->fragile));
    $this->perishable=htmlspecialchars(strip_tags($this->perishable));
    $this->price=htmlspecialchars(strip_tags($this->price));
 
    // bind values
    $stmt->bindParam(":barcode", $this->barcode);
    $stmt->bindParam(":name", $this->name);
    $stmt->bindParam(":category", $this->category);
    $stmt->bindParam(":type", $this->type);
    $stmt->bindParam(":weight", $this->weight);
    $stmt->bindParam(":manufacture_date", $this->manufacture_date);
    $stmt->bindParam(":expiray_date", $this->expiray_date);
    $stmt->bindParam(":fragile", $this->fragile);
    $stmt->bindParam(":perishable", $this->perishable);
    $stmt->bindParam(":price", $this->price);

    // execute query
    if($stmt->execute()){
        return true;
    }
 
    return false;
     
}

function update(){
 
    // update query
    $query = "UPDATE
                " . $this->table_name . "
            SET
                barcode=:barcode, name=:name, category=:category,  type=:type, weight=:weight,  manufacture_date=:manufacture_date, expiray_date=:expiray_date, perishable=:perishable, fragile=:fragile, price=:price   
            WHERE
                barcode = :barcode";
 
    // prepare query statement
    $stmt = $this->conn->prepare($query);
 
    // sanitize
    $this->barcode=htmlspecialchars(strip_tags($this->barcode));
    $this->name=htmlspecialchars(strip_tags($this->name));
    $this->category=htmlspecialchars(strip_tags($this->category));
    $this->type=htmlspecialchars(strip_tags($this->type));
    $this->weight=htmlspecialchars(strip_tags($this->weight));
    $this->manufacture_date=htmlspecialchars(strip_tags($this->manufacture_date));
    $this->expiray_date=htmlspecialchars(strip_tags($this->expiray_date));
    $this->perishable=htmlspecialchars(strip_tags($this->perishable));
    $this->fragile=htmlspecialchars(strip_tags($this->fragile));
    $this->price=htmlspecialchars(strip_tags($this->price));
    
    
    

 
    // bind new values
    $stmt->bindParam(":barcode", $this->barcode);
    $stmt->bindParam(":name", $this->name);
    $stmt->bindParam(":category", $this->category);
    $stmt->bindParam(":type", $this->type);
    $stmt->bindParam(":weight", $this->weight);
    $stmt->bindParam(":manufacture_date", $this->manufacture_date);
    $stmt->bindParam(":expiray_date", $this->expiray_date);
    $stmt->bindParam(":perishable", $this->perishable);
    $stmt->bindParam(":fragile", $this->fragile);
    $stmt->bindParam(":price", $this->price);
    
   
    // execute the query
    if($stmt->execute()){
        return true;
    }
 
    return false;
}

function delete(){
 
    // delete query
    $query = "DELETE FROM `product_shop` WHERE barcode = ?";;
 
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
