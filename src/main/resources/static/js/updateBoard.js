// pdateboardDto.fileDirList 가 0개가 아니라면 uploadedImageSetting() 호출

// 업로드했던 이미지 미리보기에 추가
function uploadedImageSetting() {

    // p tag 이미지없음 제거
	const emptyImage = document.getElementById("emptyImage");
	if (emptyImage != null) {
        emptyImage.remove();
	}
    
    const preview = document.getElementById("preview");
	// const curFiles = input.files;
    // const fileDirList; updateboardDto.fileDirList 대입

    const list = document.getElementById("imageList");

    //preview.appendChild(list);
    let imagecounting = 0;

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
        // 미리보기 개별 삭제
        removeButton.addEventListener('click', (e) => removeImage(e));
        para.appendChild(removeButton);

        const image = document.createElement('img');
        image.src = URL.createObjectURL(file);
        image.style.width = "7rem";
        image.style.height = "7rem";
        image.style.margin = "0 1rem";
        listItem.appendChild(image);
        listItem.appendChild(para);
        list.appendChild(listItem);
    }
    // filelist 업데이트
    if (curFiles != null && curFiles.length > 0) {
        for (let i = 0; i < curFiles.length; i++) {
            dataTransfer.items.add(curFiles[i])
        }
        document.getElementsByName("file")[0].files = dataTransfer.files;
    }
    const fileButton = document.getElementById("fileButton");
    fileButton.innerHTML = `업로드(${dataTransfer.files.length}/10)`;
}

// 업로드했던 이미지 remove 처리
// 태그 제거, 제거할 이미지 목록에 추가