<?php 
	$id = $_GET['id'];
	require_once('koneksi.php');
	$sql = "SELECT * FROM mahasiswa WHERE id=$id";
	$r = mysqli_query($con,$sql);

	$result = array();
	$row = mysqli_fetch_array($r);
	array_push($result,array(
			"id"=>$row['id'],
			"nim"=>$row['nim'],
			"nama"=>$row['nama'],
			"telepon"=>$row['telepon'],
			"alamat"=>$row['alamat']
		));
 
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>