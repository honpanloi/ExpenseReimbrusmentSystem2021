/**
 * 
 */
let approve_btn = document.getElementById("approve_btn")
let reject_btn = document.getElementById("reject_btn")
let view_image_btn = document.getElementById("view_image_btn")
let reimb_id = document.getElementById("reimb_id")

approve_btn.addEventListener("click", function(){
	
	if(reimb_id){
		let xhr1 = new XMLHttpRequest()
		xhr1.open('POST', 'http://localhost:8080/ExpenseReimbursementSystem/api/updateReimbursement?reimb_id='+reimb_id.value+'&status=Approved')
		xhr1.send()
		
	}
	
	let single_divs = document.getElementsByClassName("single_div")
	while(single_divs.length>0){
		single_divs[0].parentNode.removeChild(single_divs[0]);
	}
	
	setTimeout(location.reload.bind(location), 500);
})

reject_btn.addEventListener("click", function(){
	
	if(reimb_id){
		let xhr1 = new XMLHttpRequest()
		xhr1.open('POST', 'http://localhost:8080/ExpenseReimbursementSystem/api/updateReimbursement?reimb_id='+reimb_id.value+'&status=Rejected')
		xhr1.send()
		
	}
	
	let single_divs = document.getElementsByClassName("single_div")
	while(single_divs.length>0){
		single_divs[0].parentNode.removeChild(single_divs[0]);
	}
	
	setTimeout(location.reload.bind(location), 500);
})


let empl_name = null;
function getEmployeeName(empl_id){
	let xhr1 = new XMLHttpRequest()

	xhr1.open('GET', 'http://localhost:8080/ExpenseReimbursementSystem/api/viewEmployeeByID?empl_id='+empl_id)
	xhr1.send()
	
	xhr1.onreadystatechange = function(){
		if(xhr1.readyState === 4 && xhr1.status === 200){
			let employee = JSON.parse(xhr1.response)
			
			empl_name = employee.first_name+" "+employee.last_name
		}
	}
}

let g = function(){
	return "HI";
};

let d = "discription"
let i = "info"

function getReimbursement(){
	let xhr = new XMLHttpRequest()

	xhr.open('GET', 'http://localhost:8080/ExpenseReimbursementSystem/api/getPendingReimbursementByManagerID')
	xhr.send()
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			let reimbursements = JSON.parse(xhr.response)

			for (r of reimbursements){
				
				let id_dis = document.createElement('p')
				id_dis.className = d
				id_dis.textContent = "Reimbursement ID:"
				
				let empl_name_dis = document.createElement('p')
				empl_name_dis.className = d
				empl_name_dis.textContent = "Requested By:"
				
				let time_requested_dis = document.createElement("p")
				time_requested_dis.className = d
				time_requested_dis.textContent = "Time requested:"
				
				let reimb_amount_dis = document.createElement("p")
				reimb_amount_dis.className = d
				reimb_amount_dis.textContent = "Amount of reimbursement:"
				
				let event_occurred_dis = document.createElement("p")
				event_occurred_dis.className = d
				event_occurred_dis.textContent = "Event occurred on:"
				
				
				
				
				let id_info = document.createElement('p')
				id_info.className = i
				id_info.textContent = r["reimb_id"]
				
				let empl_name_info = document.createElement('p')
				empl_name_info.className = i
				empl_name_info.textContent = r["belongs_to_empl_id"]
				
				let time_requested_info = document.createElement("p")
				time_requested_info.className = i
				time_requested_info.textContent = r["time_requested"]
				
				let reimb_amount_info = document.createElement("p")
				reimb_amount_info.className = i
				reimb_amount_info.textContent = "$" + r["reimb_amount"]
				
				let event_occurred_info = document.createElement("p")
				event_occurred_info.className = i
				let parsedDate = new Date(r["event_occurred"])
				event_occurred_info.textContent = parsedDate.getFullYear() + "-" + parsedDate.getMonth() + "-" + parsedDate.getDate()
				
				
				
				let single_div = document.createElement("div")
				single_div.className = "single_div"
				
				
				single_div.append(id_dis)
				single_div.append(id_info)
				single_div.append(empl_name_dis)
				single_div.append(empl_name_info)
				single_div.append(time_requested_dis)
				single_div.append(time_requested_info)
				single_div.append(reimb_amount_dis)
				single_div.append(reimb_amount_info)
				single_div.append(event_occurred_dis)
				single_div.append(event_occurred_info)
				
				let data_div = document.getElementById("data_holder")
				data_div.append(single_div)
				
			}
		}
	}
}

window.onload = () => {
	getReimbursement()
}