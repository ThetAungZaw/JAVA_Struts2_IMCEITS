var y, x, xy, xy3, codeMirror, codeMirrorValue;
var isLocked = false;
//+ countSpaces :: String, Number -> Number
function countSpaces(str, mode) {
	if (str.substring(0, 2) == "  " && mode == 1) {
		return 1 + countSpaces(str.substring(2, str.length), 1);
	}
	else if (str.substring(0, 1) == "	" && mode == 2) {
		return 1 + countSpaces(str.substring(1, str.length), 2);
	}
	else {
		return 0;
	}
}

function statusline(a, b) {
	document.getElementById("statusline").innerHTML = "<span style='color:" + (b || "#000000") + ";'>" + a + "</span>", window.status = a, document.title = "Try Yourself";
}

function startit() {
 (view.document.open(), view.document.write(codeMirror.getValue()), view.document.close(), document.getElementById("titletext").innerHTML = "Page Title:&nbsp;" + view.document.title);
}

function init() {
document.getElementById("code1").value;
	if (location.search != null || location.search != "") {
		var a = location.search;
		a = a.split("%0A"), a = a.join("\n");
		if (a.indexOf("?") != -1) {
			var b = a.split("?");
			a = "";
			for (var c = 0; c < b.length; c++) b[c] = unescape(b[c]);
			for (var c = 1; c < b.length; c++) a += b[c];
			document.getElementById("code1").value = a;
		}
	}
	statusline(""), setInterval('document.getElementById("titletext").innerHTML="Page Title:&nbsp;"+view.document.title;', 500), codeMirror = CodeMirror.fromTextArea(document.getElementById("code1"), {
		lineNumbers: !0,
		matchBrackets: !0,
		lineWrapping: !0,
		mode: "text/html",
		tabSize: 2,
		wordWrap: true,
		autoCloseTags: true
	});
	var d = codeMirror.addLineClass(0, "background", "activeline");
	codeMirror.on("cursorActivity", function() {
		var cur = codeMirror.getLineHandle(codeMirror.getCursor().line);
		if (d != cur) {
			codeMirror.removeLineClass(d, "background", "activeline"), d = codeMirror.addLineClass(cur, "background", "activeline");
		}
		codeMirror.matchHighlight("CodeMirror-matchhighlight");
	});
	codeMirror.setOption("theme", "eclipse"), startit();
	document.getElementById("code1").addEventListener("keydown", function (e) {
		if (e.keyCode == 9) {
			e.preventDefault();
			var t = e.target;
			var ss = t.selectionStart;
			var se = t.selectionEnd;
			t.value = t.value.slice(0, ss).concat("\t").concat(t.value.slice(ss, t.value.length));
			if (ss == se) {
				t.selectionStart = t.selectionEnd = ss + 1;
			} else {
				t.selectionStart = ss + 1;
				t.selectionEnd = se + 1;
			};
		};
	}, false);
	var paragraph = document.createElement("p");
	document.body.appendChild(paragraph);
}
window.onload = init;