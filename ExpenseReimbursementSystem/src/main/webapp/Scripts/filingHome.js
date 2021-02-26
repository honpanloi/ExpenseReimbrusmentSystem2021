/**
 * 
 */

function Reimbursement(date, amount){
	this.date = date;
	this.amount = amount;
}

function fileNewReimbursement(){
	
	let url = "";
	let xhr = new XMLHttpRequest();
	
	let reimburseAmount = document.getElementById("rAmount").value;
	let submissionDate = document.getElementById("sDate").value;
	
	let Reimbursement = new Reimbursement(submissionDate, reimburseAmount)
	
	xhr.onreadystatechange = function(){
		if(xhr.status === 200 && xhr.readyState === 4){
			console.log("Oject Successfully sent!")
		}
	}
	
	xhr.open("Post", url);
	xhr.send(JSON.stringify(Reimbursement));
}

let submissionBUtton = document.querySelector('button', fileNewReimbursement);

submissionBUtton.addEventListener("click", fileNewReimbursement);