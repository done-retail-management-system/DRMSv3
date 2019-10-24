<?php
class order{
	private $conn;
	private $table_name = "order";

    public $order_id;
    public $shop_id;
    public $product_id;
	public $quantity;
    public $date_of_order;
	
	

	public function __construct($db){
		$this->conn = $db;
	}

	function read(){
 
    // select all query
    $query = "SELECT * FROM `order`";
 
    // prepare query statement
    $stmt = $this->conn->prepare($query);
 
    // execute query
    $stmt->execute();
 
    return $stmt;
	}

	// create product
// create product


function update(){
 
    // update query
    $query = "UPDATE
                " . $this->table_name . "
             SET
                date_of_order=:date_of_order, product_id=:product_id, quantity=:quantity, shop_id=:shop_id
            WHERE
                order_id = :order_id";
 
    // prepare query statement
    $stmt = $this->conn->prepare($query);
 
    // sanitize
    $this->order_id=htmlspecialchars(strip_tags($this->order_id));
    $this->quantity=htmlspecialchars(strip_tags($this->quantity));
    $this->product_id=htmlspecialchars(strip_tags($this->product_id));
    $this->shop_id=htmlspecialchars(strip_tags($this->shop_id));
    $this->date_of_order=htmlspecialchars(strip_tags($this->date_of_order));
   
    // bind new values
    $stmt->bindParam(":order_id", $this->order_id);
    $stmt->bindParam(":quantity", $this->quantity);
    $stmt->bindParam(":product_id", $this->product_id);
    $stmt->bindParam(":shop_id", $this->shop_id);
    $stmt->bindParam(":date_of_order", $this->date_of_order);
   
 
    // execute the query
    if($stmt->execute()){
        return true;
    }
 
    return false;
}

function delete(){
 
    // delete query
    $query = "DELETE FROM `order` WHERE order_id = ?";;
 
    // prepare query
    $stmt = $this->conn->prepare($query);
 
    // sanitize
    $this->order_id=htmlspecialchars(strip_tags($this->order_id));
 
    // bind id of record to delete
    $stmt->bindParam(1, $this->order_id);
 
    // execute query
    if($stmt->execute()){
        return true;
    }
 
    return false;
     
}

}

?>