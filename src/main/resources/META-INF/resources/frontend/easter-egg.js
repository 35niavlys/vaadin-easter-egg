/**
 * easter-eggs
 * 
 * Edited version of:
 * 
 * @link https://github.com/ajsoriar/easter-eggs
 * @author Andres J. Soria R. <ajsoriar@gmail.com>
 * @license MIT License, http://www.opensource.org/licenses/MIT
 */

(function() {

	'use-strict';

	window.EasterEggs = (function() {

		var arrOfKeys = [], max = 1, sequences = [];

		var checkMatch = function() {
			SEQ : for (var i = sequences.length; i-- > 0;) {
				var arrLen = arrOfKeys.length;
				var seqLen = sequences[i].seq.length;
				if (arrLen >= seqLen) {
					for (var j = 0; j++ < seqLen;) {
						var p_arr_k = arrOfKeys[arrLen - j];
						var p_arr_sec = sequences[i].seq[seqLen - j];
						if (p_arr_k !== p_arr_sec)
							continue SEQ;
					}
					sequences[i].callback();
				}
			}
		};

		var pressKey = function(keyCode) {
			if (arrOfKeys.length === max)
				arrOfKeys.shift();
			arrOfKeys.push(keyCode);
			checkMatch();
		};

		var addSequence = function(name, seq, callback) {
			if (seq.length > max)
				max = seq.length;
			sequences.push({
				name : name,
				seq : seq,
				callback : callback
			});
		};

		var removeSequence = function(name) {
			for (var i = sequences.length; i-- > 0;) {
				if (sequences[i].name == name)
					sequences.splice(i, 1);
			}
		};

		return {
			pressKey : function(keyCode) {
				pressKey(keyCode);
			},
			addSequence : function(name, arr, callback) {
				addSequence(name, arr, callback);
			},
			removeSequence : function(name) {
				removeSequence(name);
			}
		};

	})();

	window.addEventListener('keydown', function(e) {
		window.EasterEggs.pressKey(e.keyCode);
	});

}());