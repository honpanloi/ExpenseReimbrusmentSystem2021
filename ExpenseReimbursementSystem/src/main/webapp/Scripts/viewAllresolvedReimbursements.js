/**
 * 
 */

let d = "discription"
let i = "info"

function getResovled(){
	let xhr = new XMLHttpRequest();

	xhr.open('GET', 'http://3.141.97.16:8088/ExpenseReimbursementSystem/api/getAllResolvedReimbursements')
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
				let time_completed_info = document.createElement("p")
				time_completed_info.className = i
				let belongs_to_empl_id_info = document.createElement("p")
				belongs_to_empl_id_info.className = i
				let reimb_status_info = document.createElement("p")
				reimb_status_info.className = i
				
				reimb_status_info.textContent = r["reimb_status"]
				belongs_to_empl_id_info.textContent = r["belongs_to_empl_id"]
				id_info.textContent = r["reimb_id"]
				manager_id_info.textContent = r["process_by_empl_id"]
				time_requested_info.textContent = r["time_requested"]
				reimb_amount_info.textContent = "$" + r["reimb_amount"]
				time_completed_info.textContent = r["time_completed"]
				let parsedDate = new Date(r["event_occurred"])
				event_occurred_info.textContent = parsedDate.getFullYear() + "-" + parsedDate.getMonth() + "-" + parsedDate.getDate()
				
				let single_div = document.createElement("div")
				let data_div = document.getElementById("data_holder")
				
				let id_dis = document.createElement('p')
				id_dis.className = d
				id_dis.textContent = "Reimbursement ID:"
				let manager_id_dis = document.createElement("p")
				manager_id_dis.className = d
				manager_id_dis.textContent = "Reviewed by:"
				let time_requested_dis = document.createElement("p")
				time_requested_dis.className = d
				time_requested_dis.textContent = "Time requested:"
				let reimb_amount_dis = document.createElement("p")
				reimb_amount_dis.className = d
				reimb_amount_dis.textContent = "Amount of reimbursement:"
				let event_occurred_dis = document.createElement("p")
				event_occurred_dis.className = d
				event_occurred_dis.textContent = "Event occurred on:"
				let time_completed_dis = document.createElement("p")
				time_completed_dis.className = d
				time_completed_dis.textContent = "Time resolved:"
				let belongs_to_empl_id_dis = document.createElement("p")
				belongs_to_empl_id_dis.className = d
				belongs_to_empl_id_dis.textContent = "Requested by:"
				
				let reimb_status_dis = document.createElement("p")
				reimb_status_dis.className = d
				reimb_status_dis.textContent = "Result:"
				
				single_div.append(id_dis)
				single_div.append(id_info)
				single_div.append(belongs_to_empl_id_dis)
				single_div.append(belongs_to_empl_id_info)
				single_div.append(time_requested_dis)
				single_div.append(time_requested_info)
				single_div.append(reimb_amount_dis)
				single_div.append(reimb_amount_info)
				single_div.append(event_occurred_dis)
				single_div.append(event_occurred_info)
				single_div.append(manager_id_dis)
				single_div.append(manager_id_info)
				single_div.append(reimb_status_dis)
				single_div.append(reimb_status_info)
				single_div.append(time_completed_dis)
				single_div.append(time_completed_info)
				
				single_div.className = "single_div"
				
				data_div.append(single_div)
			}
		}
	}
}

window.onload = () => {
	getResovled()
}
