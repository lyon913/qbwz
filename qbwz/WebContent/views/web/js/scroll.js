function scrollElement(eleid) {
	ele = document.getElementById(eleid);
	eleDiv = ele.getElementsByTagName("ul")[0];
	eleClone = eleDiv.cloneNode(true);
	ele.appendChild(eleClone);
	flgStop = false;
	var scrollTop = 0;
	ele.onmouseover = function() {
		flgStop = true;
	};
	ele.onmouseout = function() {
		flgStop = false;
	};

	this.startUp = function() {
		if (flgStop)
			return;
		scrollTop++;
		if (scrollTop >= eleClone.offsetHeight) {
			scrollTop = 0;
		}
		ele.scrollTop = scrollTop;
	};
	this.start = function(xname) {
		var intval = setInterval(xname + ".startUp();", 50);
	};
};
