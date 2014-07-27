/* 
   Simple JQuery Collapsing menuv.
   HTML structure to use:

   <ul id="menuv">
     <li><a href="#">Sub menuv heading</a>
     <ul>
       <li><a href="http://site.com/">Link</a></li>
       <li><a href="http://site.com/">Link</a></li>
       <li><a href="http://site.com/">Link</a></li>
       ...
       ...
     </ul>
     <li><a href="#">Sub menuv heading</a>
     <ul>
       <li><a href="http://site.com/">Link</a></li>
       <li><a href="http://site.com/">Link</a></li>
       <li><a href="http://site.com/">Link</a></li>
       ...
       ...
     </ul>
     ...
     ...
   </ul>

Copyright 2007 by Marco van Hylckama Vlieg
Download by http://sc.xueit.com
web: http://www.i-marco.nl/weblog/
email: marco@i-marco.nl

Free for non-commercial use
*/

function initmenuv() {
  $('#menuv ul').hide();
  $('#menuv li a').click(
    function() {
        $(this).next().slideToggle('normal');	
      }
    );
  }
$(document).ready(function() {initmenuv();});