/**
 * 
 */

let vPending_btn = document.getElementById("vPending_btn")
let vResolved_btn = document.getElementById("vResolved_btn")


let d = "discription"

let i = "info"

function getPeding(){
	let xhr = new XMLHttpRequest();

	xhr.open('GET', 'http://localhost:8080/ExpenseReimbursementSystem/api/getPendingReimbursementByEmployeeID')
	xhr.send()
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			let reimbursement = JSON.parse(xhr.response)
			
			for(let r of reimbursement){
				
				let id_info = document.createElement("p")
				id_info.className = i
				let manager_id_info = document.createElement("p")
				manager_id_info.className = i
				let time_requested_info = document.createElement("p")
				time_requested_info.className = i
				let reimb_amount_info = document.createElement("p")
				reimb_amount_info.className = i
				let event_occurred_info = document.createElement("p")
				event_occurred_info.className = i
				
				id_info.textContent = r["reimb_id"]
				manager_id_info.textContent = r["process_by_empl_id"]
				time_requested_info.textContent = r["time_requested"]
				reimb_amount_info.textContent = "$" + r["reimb_amount"]
				event_occurred_info.textContent = r["event_occurred"]
				
				let single_div = document.createElement("div")
				let data_div = document.getElementById("data_holder")
				
				let id_dis = document.createElement('p')
				id_dis.className = d
				id_dis.textContent = "Reimbursement ID:"
				let manager_id_dis = document.createElement("p")
				manager_id_dis.className = d
				manager_id_dis.textContent = "Will be reviewed by:"
				let time_requested_dis = document.createElement("p")
				time_requested_dis.className = d
				time_requested_dis.textContent = "Requested at:"
				let reimb_amount_dis = document.createElement("p")
				reimb_amount_dis.className = d
				reimb_amount_dis.textContent = "Amount of reimbursement:"
				let event_occurred_dis = document.createElement("p")
				event_occurred_dis.className = d
				event_occurred_dis.textContent = "Event occurred on:"
				
				single_div.append(id_dis)
				single_div.append(id_info)
				single_div.append(time_requested_dis)
				single_div.append(time_requested_info)
				single_div.append(reimb_amount_dis)
				single_div.append(reimb_amount_info)
				single_div.append(event_occurred_dis)
				single_div.append(event_occurred_info)
				single_div.append(manager_id_dis)
				single_div.append(manager_id_info)
				
				data_div.append(single_div)
			}
		}
	}
}

window.onload = () => {
	getPeding()
	console.log("hi")
}