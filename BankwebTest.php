<?php


class BankWebTest{


        function getData(){
                $url = "http://localhost:8080/transactions/statement";
				 //$url = "http://localhost:8080/transactions/deposit";
				 //$url = "http://localhost:8080/transactions/withdraw";
				

                $data = array(
                                'accountnumber'=>'0102999292',
                                'amount'=>200,
                                
                             );
			    $password="41146b0c-0621-4ad3-9815-d2278a6d424e";
                $user='user';
                $ch = curl_init();

                curl_setopt($ch,CURLOPT_URL,$url);
                curl_setopt($ch,CURLOPT_RETURNTRANSFER,true);
                curl_setopt($ch,CURLOPT_HEADER, false);
                curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
                curl_setopt($ch, CURLOPT_USERPWD, "$user:$password");

                //var_dump($data);
                $output=curl_exec($ch);


                curl_close($ch);
                echo $output;
        }
}
$r = new BankWebTest();
$r-> getData();
