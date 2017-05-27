$(function() {
	$.widget( "ui.viewusers", {
		options: {
			value: 0
		},
		_create: function() {
			// Create the structure
			this.element.addClass("view-user-ref");
			$(this.element).append($('<h3>Users:</h3>'));
			var mainDiv = $('<div class="viewusersDiv"></div>');
			$(this.element).append(mainDiv);
			$(".viewusersDiv").jsGrid({
		        inserting: false,
		        editing: true,
		        sorting: false,
		        paging: false,

		        height: "auto",
		        width: "100%",
		 
		        autoload: true,
		        
		        deleteItem: function(item){ 
		        	$.ajax({
		        	    url: 'user',
		        	    type: 'DELETE',
					    dataType: 'json',
					    headers: { 
					        'Accept': 'application/json', 
					        'Content-Type': 'application/json' 
					    },
					    data: JSON.stringify({"id": item.id}),
		        	    success: function(result) {
		        	    	$(".viewusersDiv").jsGrid("loadData");
		        	    	
		        	    	$('.post-result').html('Delete successfully!');
					    	$('.post-result').removeClass('wrong-entry');
					    	$('.post-result').addClass('right-entry');
							$('.post-result').fadeIn(500);
							setTimeout( "$('.post-result').fadeOut(1500);", 15000);

		        	    }
		        	});
		        },
		        editItem: function(id){ 
		            console.log(id); 
		        },
		        controller: {
		            loadData: function() {
		                var d = $.Deferred();
		 
		                $.ajax({
		                    url: "user",
		                    dataType: "json"
		                }).done(function(response) {
		                    d.resolve(response);
		                });
		 
		                return d.promise();
		            }
		        },

		        fields: [
		        	{ name: "id", type: "text", width: 50, validate: "required", title: "Id"},
		        	{ name: "name", type: "text", width: 100, validate: "required", title: "Name"},
		            { name: "username", type: "text", title: "Username", width: 100 },
		            { name: "activityStyle", type: "text", width: 100, title: "Activity Style"},
		            { name: "birthDate", type: "text", width: 100, title: "BirthDate",
		            	itemTemplate: function(value, item) {
		            		console.log("value  " + value);
		            		var date = (new Date(value*1)).toLocaleString();
		            		
		            		console.log("date  " + date);
		            		return $("<span>" + date + "</span>");
		            	}
	            	},
		            { name: "email", type: "text", width: 170, title: "Email"},
		            { name: "gender", type: "text", title: "Gender"},
		            { name: "height", type: "text", title: "Height"},
		            { name: "weight", type: "text", title: "Weight"}
//		            { name: "id", type: "control", editButton: false, width: 150,
//		            	itemTemplate: function(value, item) {
//		                    var $result = jsGrid.fields.control.prototype.itemTemplate.apply(this, arguments);
//		                    
//	                    	var linkId = "viewItemLink_"+ getRandomNumber();
//			                    
//		                    var itemsContent = $("<div>");
//		                    itemsContent.dialog({
//		                        autoOpen: false, 
//		                        title: "View items ("+item.items.length+")",
//		                        width: "500px",
//		                        position: { my: "center", at: "top" }
//		                    });
//		                    var itemsTable = $("<table buser='1' width='100%'>");
//		                    itemsTable.append($("<tr><th>Index</th><th>Name</th><th>Quantity</th><th>Rate</th><th>Selling Price</th></tr>'"))
//		                    var i = 0;
//		                    $.each(item.items, function (i, itm) {
//		                    	i++;
//		                    	var nameLbl = "<label id=\"itemDetName_" + getRandomNumber() + "\">" + itm.name + "</label>"
//		                    	
//		                    	itemsTable.append('<tr><td>'+i+'</td><td>' + nameLbl + '</td><td>' + itm.quantity + 
//		                    			'</td><td>' + itm.rate + '</td><td>' + itm.sellingPrice + '</td></tr>');
//		                    });
//		                    var title = $("<span>Items details for the sales user (" + item.salesuser + "):</span>");
//		                    itemsContent.append(title);
//		                    itemsContent.append(itemsTable);
//
//		                    var total = $("<span>Total number of items (<span class=\"dialogDetailsTotalItems_" + getRandomNumber() + "\">" + item.items.length + "</span>):</span>");
//		                    itemsContent.append(total);
//		                    
//		                    var $customButton = $("<a>")
//		                    	.html("<span style='padding-left: 5px;' id='" +linkId + "'>View Items (<span class=\"userTotalItems_" + getRandomNumber() + "\">" + item.items.length + "</span>)</span>")
//		                    	.click(function(e) {
//		                    		itemsContent.dialog( "open" );
//		                            e.stopPropagation();
//		                        });
//		                    return $result.add($customButton);
//		                }
//		            }
		        ]
		    });
	    },
	    _destroy: function() {
	    	this.element.removeClass("view-user-ref").text("");
	    }
	});
});
