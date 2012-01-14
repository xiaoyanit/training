function talk(page) {
	if (page === "?") {
		alert("talk not ready");
		return;
	}
	window.open('talk/' + page + ".html", "_self", false);
}

function exercise(page) {
	if (page === "?") {
		alert("exercise not ready");
		return;
	}
	window.open('exercise/' + page + ".html", "_self", false);
}

function training(page) {
	if (page === "?") {
		alert("training not ready");
		return;
	}
	window.open(page + ".html", "_self", false);
}

function pdf(page) {
	if (page === "?") {
		alert("pdf not ready");
		return;
	}
	window.open('pdf/' + page + ".pdf", "_self", false);
}