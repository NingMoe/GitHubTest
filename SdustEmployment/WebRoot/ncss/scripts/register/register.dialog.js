
(function($) {
  function Popup(el,id) {
	this.nameInput = $(el);
	this.nameInput.attr("readonly", "readonly");
	this.idInput = this.nameInput.prev();
    this.InputId = id;
        
    this.bindMethodsToObj("show", "hide", "hideIfClickOutside", "selectItem");
    
    this.build();
    //this.selectItem();
    this.hide();
  };

  Popup.prototype = {
	
    build: function() {
      //清空按钮
        this.ClearController = $('<div class="button"><a href="#">清 空</a></div>').click(this.bindToObj(function(event) {
        this.selectItem("", "");
        this.hide();
        return false;
      })); 
   
      this.popupController = $('<div class="selecting"></div>').append(this.ClearController);

	  
	 
      //特殊方法针对注册、添加弹出的dialog
      var list = $('<ul></ul>');

      if(this.InputId=="Nature"){
    	  $.each(natureItems,function(){
    		  list.append('<li><a href="#" id="' + this.id +'">'+ this.name +'</a></li>');
    	  });
    	  this.popupContent = $('<div></div>').addClass('natureDialog-content');
      }
      if(this.InputId=="Industry"){
    	  $.each(industryItems, function(){
    		  list.append('<li><a href="#" id="' + this.id +'">'+ this.name +'</a></li>');
    	  });
    	  this.popupContent = $('<div></div>').addClass('industryDialog-content');
      }
      if(this.InputId=="Province"){
    	  $.each(provinceItems, function(){
    		  list.append('<li><a href="#" id="' + this.id +'">'+ this.name +'</a></li>');
    	  });
    	  this.popupContent = $('<div></div>').addClass('ProvinceDialog-content');
      }
      if(this.InputId=="Category"){
    	  $.each(jobcategoryItems, function(){
    		  list.append('<li><a href="#" id="' + this.id +'">'+ this.name +'</a></li>');
    	  });
    	  this.popupContent = $('<div></div>').addClass('CategoryDialog-content');
      }
     
      if(this.InputId=="Nation"){
    	  $.each(nationItems, function(){
    		  list.append('<li><a href="#" id="' + this.id +'">'+ this.name +'</a></li>');
    	  });
    	  this.popupContent = $('<div></div>').addClass('CategoryDialog-content');
      }
      if(this.InputId=="Political"){
    	  $.each(politicalItems, function(){
    		  list.append('<li><a href="#" id="' + this.id +'">'+ this.name +'</a></li>');
    	  });
    	  this.popupContent = $('<div></div>').addClass('PoliticalDialog-content');
      }
      
      list.prependTo(this.popupContent);
      this.popupPanel = this.rootLayers = $('<div class="selectorDialog"></div>')
        .css({ display: "none", position: "absolute", zIndex: 900 })
        .append(this.popupController,this.popupContent)
        .appendTo(document.body);
      
      if ($.browser.msie && $.browser.version < 7) {
        this.ieframe = $('<iframe class="dialog_iframe" frameborder="0" src="#"></iframe>')
          .css({ position: "absolute", display: "none", zIndex: 99 })
          .insertBefore(this.popupPanel);
        this.rootLayers = this.rootLayers.add(this.ieframe);
      };
      
      $("a", this.popupContent).click(this.bindToObj(function(event) {
        this.selectItem($(event.target).attr("id"), $(event.target).attr("innerHTML"));
        this.hide();
        return false;
      }));

      //this.nameInput.change(this.bindToObj(function() { this.selectItem(); }));
    }, 
    
    selectItem: function(item, text) {  
    	this.nameInput.val(text);
		this.idInput.val(item);
    },
    
    show: function() {
      this.setPosition();
      this.rootLayers.css("display", "block");
      this.nameInput.unbind("focus", this.show);
      $(document.body).click(this.hideIfClickOutside);
    },
    
    hide: function() {
      this.rootLayers.css("display", "none");
      $(document.body).unbind("click", this.hideIfClickOutside);
      this.nameInput.focus(this.show);
    },
    
    hideIfClickOutside: function(event) {
      if (event.target != this.nameInput[0] && !this.insideSelector(event)) {
        this.hide();
      };
    }, 
     
    setPosition: function() {
      var offset = this.nameInput.offset();
      this.rootLayers.css({
        top: offset.top + this.nameInput.outerHeight(),
        left: $(window).width()/2 - this.rootLayers.outerWidth()/2
        //left: offset.left
      });
      
      if (this.ieframe) {
        this.ieframe.css({
          width: this.popupPanel.outerWidth(),
          height: this.popupPanel.outerHeight()
        });
      };
    },  
     
    insideSelector: function(event) {
      var offset = this.popupPanel.offset();
      offset.right = offset.left + this.popupPanel.outerWidth();
      offset.bottom = offset.top + this.popupPanel.outerHeight();
      
      return event.pageY < offset.bottom &&
             event.pageY > offset.top &&
             event.pageX < offset.right &&
             event.pageX > offset.left;
    },
    
    bindToObj: function(fn) {
      var self = this;
      return function() { return fn.apply(self, arguments) };
    },
    
    bindMethodsToObj: function() {
      for (var i = 0; i < arguments.length; i++) {
        this[arguments[i]] = this.bindToObj(this[arguments[i]]);
      };
    } 
    
  };

  $.fn.popup = function(id) {
    return this.each(function() { 
      new Popup(this,id); 
    });
  };
})(jQuery);