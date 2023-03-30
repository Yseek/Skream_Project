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

Array.from(removeUploadedImageButton).forEach(element => {
    element.addEventListener('click', function(e){
        e.preventDefault();

        imgTag = e.target.parentElement.parentElement;
        let data = new Object();
        data.fileId = imgTag.id;
        removeList.push(data);
        let jsonData = JSON.stringify(removeList);
        let removeListTag = document.getElementsByName("removeList")[0];
        removeListTag.value = jsonData;        
        imgTag.remove(); 
        
        imagecounting -= 1;
        const fileButton = document.getElementById("fileButton");
		fileButton.innerHTML = `업로드(${imagecounting}/10)`;
    })
});
