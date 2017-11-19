<?php

require "init.php";

try {
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	
	$plakaty = array();
	$stmt = $conn->query("SELECT ID_PLAKAT, NAZWA, OPIS, MIASTO, ADRES, DATA_POCZATEK,
						DATA_KONIEC, GODZIN_POCZATEK, GODZINA_KONIEC, IMG_URL, INFO_URL,
						FACEBOOK_URL, BILET_URL FROM PLAKAT 
						ORDER BY DATA_POCZATEK, GODZIN_POCZATEK LIMIT 0 , 200");
	
	while(($result = $stmt->fetch(PDO::FETCH_NUM)) != null){
			array_push($plakaty, array("ID_PLAKAT"=>$result[0],
								"NAZWA"=>$result[1],
								"OPIS"=>$result[2],
								"MIASTO"=>$result[3],
								"ADRES"=>$result[4],
								"DATA_POCZATEK"=>$result[5],
								"DATA_KONIEC"=>$result[6],
								"GODZIN_POCZATEK"=>$result[7],
								"GODZINA_KONIEC"=>$result[8],
								"IMG_URL"=>$result[9],
								"INFO_URL"=>$result[10],
								"FACEBOOK_URL"=>$result[11],
								"BILET_URL"=>$result[12]));
		}
	if($plakaty != null){
		echo json_encode($plakaty, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE | JSON_ERROR_UTF8);
	}else{
		echo "Pusto";
	}
	
	}catch(PDOException $e){
	echo $sql . "<br>" . $e->getMessage();
	}
?>