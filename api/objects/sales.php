<?php
class sales{
	private $conn;
	private $table_name = "sales";

	public $sales_id;
	public $date;
	public $barcode;
	public $transaction_type;
	public $amount;
	

	public function __construct($db){
		$this->conn = $db;
	}

	function read(){
 
    // select all query
    $query = "SELECT * FROM `sales`";
 
    // prepare query statement
    $stmt = $this->conn->prepare($query);
 
    // execute query
    $stmt->execute();
 
    return $stmt;
	}



	function readOne(){
 
    // query to read single record
    $query = "SELECT * FROM `sales` WHERE sales_id = ?";
 
    // prepare query statement
    $stmt = $this->conn->prepare( $query );
 
    // bind id of product to be updated
    $stmt->bindParam(1, $this->sales_id);
 
    // execute query
    $stmt->execute();
 
    // get retrieved row
    $row = $stmt->fetch(PDO::FETCH_ASSOC);
 
    // set values to object properties
    $this->sales_id = $row['sales_id'];
    $this->date = $row['date'];
    $this->barcode = $row['barcode'];
    $this->transaction_type = $row['transaction_type'];
    $this->amount = $row['amount'];
   
}

function update(){
 
    // update query
    $query = "UPDATE
                " . $this->table_name . "
            SET
                sales_id=:sales_id, date=:date, barcode=:barcode, transaction_type=:transaction_type, amount=:amount
            WHERE
                sales_id = :sales_id";
 
    // prepare query statement
    $stmt = $this->conn->prepare($query);
 
    // sanitize
    $this->sales_id=htmlspecialchars(strip_tags($this->sales_id));
    $this->date=htmlspecialchars(strip_tags($this->date));
    $this->barcode=htmlspecialchars(strip_tags($this->barcode));
    $this->transaction_type=htmlspecialchars(strip_tags($this->transaction_type));
    $this->amount=htmlspecialchars(strip_tags($this->amount));
   
 
    // bind new values
    $stmt->bindParam(":sales_id", $this->sales_id;
    $stmt->bindParam(":date", $this->date);
    $stmt->bindParam(":barcode", $this->barcode);
    $stmt->bindParam(":transaction_type", $this->transaction_type);
    $stmt->bindParam(":amount", $this->amount);
    
 
    // execute the query
    if($stmt->execute()){
        return true;
    }
 
    return false;
}

function delete(){
 
    // delete query
    $query = "DELETE FROM `sales` WHERE sales_id = ?";;
 
    // prepare query
    $stmt = $this->conn->prepare($query);
 
    // sanitize
    $this->sales_id=htmlspecialchars(strip_tags($this->sales_id));
 
    // bind id of record to delete
    $stmt->bindParam(1, $this->sales_id);
 
    // execute query
    if($stmt->execute()){
        return true;
    }
 
    return false;
     
}

}
?>