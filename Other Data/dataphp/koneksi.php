<?php

 define('HOST','localhost');
 define('USER','root');
 define('PASS','mgma');
 define('DB','rest_enterprise');

 $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
 ?>