<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$nim = $_POST['nim'];
		$nama = $_POST['nama'];
		$telepon = $_POST['telepon'];
		$alamat = $_POST['alamat'];
		
		$sql = "INSERT INTO mahasiswa (nim,nama,telepon,alamat) VALUES ('$nim','$nama','$telepon','$alamat')";
		
		require_once('koneksi.php');
		
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Mahasiswa';
		}else{
			echo 'Gagal Menambahkan Mahasiswa';
		}
		
		mysqli_close($con);
	}
?>