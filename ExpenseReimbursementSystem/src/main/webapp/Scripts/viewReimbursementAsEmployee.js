/**
 * 
 */

let vPending_btn = document.getElementById("vPending_btn").addEventListener("click", function(){
	let single_divs = document.getElementsByClassName("single_div")
	while(single_divs.length>0){
		single_divs[0].parentNode.removeChild(single_divs[0]);
	}
	
	getPeding()
})
let vResolved_btn = document.getElementById("vResolved_btn").addEventListener("click", function(){
	let single_divs = document.getElementsByClassName("single_div")
	while(single_divs.length>0){
		single_divs[0].parentNode.removeChild(single_divs[0]);
	}
	
	getResovled()
})


let d = "discription"
let i = "info"

let manger_name = document.getElementsByClassName("manager_name")

function getManager(){
	let xhr = new XMLHttpRequest();

	xhr.open('GET', 'http://3.141.97.16:8088/ExpenseReimbursementSystem/api/viewManagerByEmployeeID')
	xhr.send()
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			let manager = JSON.parse(xhr.response)
			
			for(let m of manger_name){
				m.textContent = manager.first_name + " " + manager.last_name
			}
			
			//manger_name.textContent = manager.first_name + " " + manager.last_name
			
		}
	}
}




function getPeding(){
	let xhr = new XMLHttpRequest();

	xhr.open('GET', 'http://3.141.97.16:8088/ExpenseReimbursementSystem/api/getPendingReimbursementByEmployeeID')
	xhr.send()
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			let reimbursement = JSON.parse(xhr.response)
			
			for(let r of reimbursement){
				
				let id_info = document.createElement("p")
				id_info.className = i
				let manager_id_info = document.createElement("p")
				manager_id_info.className = "manager_name"
				let time_requested_info = document.createElement("p")
				time_requested_info.className = i
				let reimb_amount_info = document.createElement("p")
				reimb_amount_info.className = i
				let event_occurred_info = document.createElement("p")
				event_occurred_info.className = i
				
				id_info.textContent = r["reimb_id"]
				manager_id_info.textContent = manger_name
				time_requested_info.textContent = r["time_requested"]
				reimb_amount_info.textContent = "$" + r["reimb_amount"]
				let parsedDate = new Date(r["event_occurred"])
				event_occurred_info.textContent = parsedDate.getFullYear() + "-" + parsedDate.getMonth() + "-" + parsedDate.getDate()
				
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
				time_requested_dis.textContent = "Time requested:"
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
				
				single_div.className = "single_div"
				
				data_div.append(single_div)
			}
			
			manger_name = document.getElementsByClassName("manager_name")
			getManager()
			
			document.getElementById("vPending_btn").style.backgroundColor = "#9de3bf"
			document.getElementById("vResolved_btn").style.backgroundColor = "#e6e6e6"
		}
	}
}

function getResovled(){
	let xhr = new XMLHttpRequest();

	xhr.open('GET', 'http://3.141.97.16:8088/ExpenseReimbursementSystem/api/getResolvedReimbursementByEmployeeID')
	xhr.send()
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			let reimbursement = JSON.parse(xhr.response)
			
			for(let r of reimbursement){
				
				let id_info = document.createElement("p")
				id_info.className = i
				let manager_id_info = document.createElement("p")
				manager_id_info.className = "manager_name"
				let time_requested_info = document.createElement("p")
				time_requested_info.className = i
				let reimb_amount_info = document.createElement("p")
				reimb_amount_info.className = i
				let event_occurred_info = document.createElement("p")
				event_occurred_info.className = i
				let time_completed_info = document.createElement("p")
				time_completed_info.className = i
				
				id_info.textContent = r["reimb_id"]
				manager_id_info.textContent = manger_name
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
				single_div.append(time_completed_dis)
				single_div.append(time_completed_info)
				
				single_div.className = "single_div"
				
				data_div.append(single_div)
			}
			
			manger_name = document.getElementsByClassName("manager_name")
			getManager()
			
			document.getElementById("vPending_btn").style.backgroundColor = "#e6e6e6"
			document.getElementById("vResolved_btn").style.backgroundColor = "#9de3bf"
		}
	}
}

window.onload = () => {
	getPeding()
}
