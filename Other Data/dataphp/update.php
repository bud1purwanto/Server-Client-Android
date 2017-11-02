<?php 

	if($_SERVER['REQUEST_METHOD']=='POST'){
		$id = $_POST['id'];
		$nim = $_POST['nim'];
		$nama = $_POST['nama'];
		$telepon = $_POST['telepon'];
		$alamat = $_POST['alamat'];
		
		require_once('koneksi.php');

		$sql = "UPDATE mahasiswa SET nim = '$nim', nama = '$nama', telepon = '$telepon', alamat = '$alamat' WHERE id = $id;";
		
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data Mahasiswa';
		}else{
			echo 'Gagal Update Data Mahasiswa';
		}
		
		mysqli_close($con);
	}
?>