function check() {
	let theForm = document.input
	let content = document.getElementsByName("content")[0].value;
	if (theForm.subject.value == "" || content == "") {
		alert("모든 값을 입력 하셔야 합니다. ");
		return false;
	}
	document.input.submit();
}

const dataTransfer = new DataTransfer();
const imageLimit = 10;
var imagecounting = 0;

function updateImageDisplay() {
	const emptyImage = document.getElementById("emptyImage");
	if (emptyImage != null) {
		emptyImage.remove();
	}

	const input = document.getElementsByName("file")[0];
	const curFiles = input.files;

	console.log("dataTransfer.files.length: ", dataTransfer.files.length);
	console.log("curFiles.length: ", curFiles.length);

	if (curFiles.length + dataTransfer.files.length > imageLimit) {
		alert(`이미지는 ${imageLimit}개 이하로 올려주세요`);
		return;
	} else {
		const list = document.getElementById("imageList");

		for (const file of curFiles) {
			imagecounting += 1;
			const listItem = document.createElement('li');
			const para = document.createElement('p');
			para.textContent = file.name.length < 10 ? file.name : file.name.substring(0, 6) + "... ";
			para.style.textAlign = "center";

			listItem.id = file.lastModified;
			const removeButton = document.createElement('button');
			removeButton.textContent = "X";
			removeButton.dataset.index = file.lastModified;
			removeButton.addEventListener('click', (e) => removeImage(e));
			para.appendChild(removeButton);

			const image = document.createElement('img');
			image.src = URL.createObjectURL(file);
			image.classList.add("imagefile");
			listItem.appendChild(image);
			listItem.appendChild(para);
			list.appendChild(listItem);
		}
		if (curFiles != null && curFiles.length > 0) {
			for (let i = 0; i < curFiles.length; i++) {
				dataTransfer.items.add(curFiles[i])
			}
			document.getElementsByName("file")[0].files = dataTransfer.files;
		}
		const fileButton = document.getElementById("fileButton");
		fileButton.innerHTML = `업로드(${imagecounting}/10)`;
	}
}

function removeImage(e){
    e.preventDefault();
    const removeTargetId = e.target.dataset.index;
    const removeTarget = document.getElementById(removeTargetId);
	
	const dataList = dataTransfer.files;
	for(let i=0; dataList.length; i++){
		if(dataList[i].lastModified == removeTargetId){
			dataTransfer.items.remove(i);
			break;
		}
	}
	const newFiles = document.getElementsByName("file")[0].files = dataTransfer.files;
	removeTarget.remove();

	// 업로드할 이미지 갯수 갱신
	imagecounting -= 1;
	const fileButton = document.getElementById("fileButton");
	fileButton.innerHTML = `업로드(${imagecounting}/10)`;

	if (newFiles.length == 0) {
		const preview = document.getElementById("preview");
		const para = document.createElement('p');
		para.id = "emptyImage";
		para.textContent = "업로드할 이미지를 선택해주세요";
		preview.appendChild(para);
	}

}
