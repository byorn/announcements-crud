$(function(){
    
    // Initialize Popup Window
    $('.open-popup-link').magnificPopup({
        type:'inline',
        midClick: true // Allow opening popup on middle mouse click. Always set it to true if you don't provide alternative source in href.
    });
    
    
    //Initialize JQuery Forms Plugin
    $('#announcementForm').ajaxForm({ 
       
        success:   refreshTableAndClosePopup 
    }); 
    
       
    
     //On row select of the table
     $('#announcements-table').bootstrapTable({
     }).on('click-row.bs.table', function (e, row, $element) {
                
               //when the row is selected set the fields to the form          
                var selectedRow = JSON.stringify(row);
                var obj = jQuery.parseJSON( selectedRow );
                setFieldsToForm(obj);
                
     }) .on('check.bs.table', function (e, row) {
                
                //when the checkbox of the row is selected set the fields to the form
                var selectedRow = JSON.stringify(row);
                var obj = jQuery.parseJSON( selectedRow );
                setFieldsToForm(obj);
     });
     
     function setFieldsToForm(row){
         $("#id").val(row.id);
         $("#title").val(row.title);
         $("#body").val(row.body);
         $("#startdate").val(row.startDate);
         $("#expirydate").val(row.expiryDate);
     }

    //when create new button is pressed , clear all the fields in the form
    $("#createNewButton").click(function(){
        $("#id").val("");
        $("#title").val("");
        $("#body").val("");
        $("#expirydate").val("");
        $("#startdate").val("");
    });
    
    //when the delete button is pressed call the delete jax rs service
    $("#delete").click(function(){
       
       var selectedRow = JSON.stringify($("#announcements-table").bootstrapTable('getSelections')); 
       
       var rowObj = eval(selectedRow);
       
       $.ajax({
             url: "http://localhost:8080/announcement/webresources/rest/"+rowObj[0].id,
             type: "delete"
             
       }).done(function( msg ) {
             refreshTableAndClosePopup();
       });
      
       
    });
    
    
    
    function refreshTableAndClosePopup(){
        //refresh the table
        $("#announcements-table").bootstrapTable('refresh', { });
        //close the popup
        $.magnificPopup.instance.close();
    }
    
});
