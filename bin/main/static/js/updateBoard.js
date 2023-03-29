function initImagecounting(uploadedimage){
    imagecounting += uploadedimage.length;
    if(uploadedimage[0].orgnm=="noImage.png"){
        imagecounting -= 1;
    }
    const fileButton = document.getElementById("fileButton");
	fileButton.innerHTML = `업로드(${imagecounting}/10)`;
}

let removeUploadedImageButton = document.getElementsByClassName("removeUploadedImage");
var removeList = new Array();

// 업로드했던 이미지 remove 처리
Array.from(removeUploadedImageButton).forEach(element => {
    element.addEventListener('click', function(e){
        e.preventDefault();

        imgTag = e.target.parentElement.parentElement;
        // 제거할 이미지 목록에 추가
        let data = new Object();
        data.fileId = imgTag.id;
        removeList.push(data);
        let jsonData = JSON.stringify(removeList);
        let removeListTag = document.getElementsByName("removeList")[0];
        console.log(removeListTag);
        removeListTag.value = jsonData;        
        // 이미지 태그 제거
        imgTag.remove(); 
        
        // imagecounting과 버튼 텍스트 수정
        imagecounting -= 1;
        console.log(imagecounting);
        const fileButton = document.getElementById("fileButton");
		fileButton.innerHTML = `업로드(${imagecounting}/10)`;
    })
});
