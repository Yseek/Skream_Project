function check(){
    for(var i=0; i<document.input.elements.length; i++){
       if(document.input.elements[i].value === ""){
        if(document.input.elements[i].name === "file"){
            continue;
        }  
        alert("모든 값을 입력 하셔야 합니다. ");
          return false;
       }
    }
    document.input.submit();
}

function updateImageDisplay() {
     let preview = document.getElementById("preview");
     const imageLimit = 10;
     
     while(preview.firstChild) {
         preview.removeChild(preview.firstChild);
     }
     
     let input = document.getElementById("file");
     const curFiles = input.files;
     
     if(curFiles.length === 0) {
         const para = document.createElement('p');
         para.textContent = '이미지 없음';
         preview.appendChild(para);
     }else if(curFiles.length > imageLimit){
         const para = document.createElement('p');
         para.textContent = `이미지는 ${imageLimit}개 이하로 올려주세요`;
         preview.appendChild(para);
         return;
     }else{
         const list = document.createElement('ol');
         preview.appendChild(list);
         let imagecounting = 0;
         
         for(const file of curFiles) {
             imagecounting += 1;
             const listItem = document.createElement('li');
             const para = document.createElement('p');
             para.textContent = file.name.length < 12 ? file.name : file.name.substring(0, 8) + "...";
             console.log(imagecounting + "번째 이름 길이 : " + file.name.length);
             para.style.textAlign = "center";
             const image = document.createElement('img');
             image.src = URL.createObjectURL(file);
             image.style.width = "7em";
             image.style.height = "7em";
             image.style.margin = "0 1em";
             listItem.appendChild(image);
             listItem.appendChild(para);
             list.appendChild(listItem);
         }
         const fileButton = document.getElementById("fileButton");
         fileButton.innerHTML = `업로드(${imagecounting}/10)`;
     }
}

