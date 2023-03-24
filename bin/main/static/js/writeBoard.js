function check(){
    for(var i=0; i<document.input.elements.length; i++){
       if(document.input.elements[i].value == ""){
        if(document.input.elements[i].name == "file"){
            continue;
        }
        console.log(`빈 칸 체크 name: ${document.input.name}`)
        alert("모든 값을 입력 하셔야 합니다. ");
          return false;
       }
    }
    document.input.submit();
}

const dataTransfer = new DataTransfer();

function updateImageDisplay() {
     const preview = document.getElementById("preview");
     // p tag 이미지없음 제거
     const emptyImage = document.getElementById("emptyImage");
     if(emptyImage != null){
        emptyImage.remove();
     }
     
     const imageLimit = 10;
     
     const input = document.getElementById("file");
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
         // 태그 가져오는 걸로 수정
         //const list = document.createElement('ol');
         const list = document.getElementById("imageList");

         preview.appendChild(list);
         let imagecounting = 0;
         
         for(const file of curFiles) {
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
             image.style.width = "7em";
             image.style.height = "7em";
             image.style.margin = "0 1em";
             listItem.appendChild(image);
             listItem.appendChild(para);
             list.appendChild(listItem);
            }
            // filelist 업데이트
            if(curFiles != null && curFiles.length>0){
                 for(let i=0; i<curFiles.length; i++){
                     dataTransfer.items.add(curFiles[i])
                 }
                 document.getElementById("file").files = dataTransfer.files;
                 console.log("dataTransfer =>",dataTransfer.files);
                 console.log("input FIles =>", document.getElementById("file").files);                
             }
         const fileButton = document.getElementById("fileButton");
         fileButton.innerHTML = `업로드(${dataTransfer.files.length}/10)`;
     }
}

function removeImage(e){
    e.preventDefault();
    // 버튼의 부모의 부모 태그(li)를 제거
    const removeTargetId = e.target.dataset.index;
    const removeTarget = document.getElementById(removeTargetId);
    // 해당 파일 제거(해당 파일을 제외한 나머지 파일을 새로 filelist에 담는다)
    const originFiles = document.getElementById("file").files;
    console.log(`originFiles.length : ${originFiles.length}`);

    Array.from(dataTransfer.files)
        .filter(file => file.lastModified == removeTargetId)
        .forEach(file => {
            dataTransfer.items.remove(file);
            console.log("dataTransfer =>",dataTransfer.files);
            console.log("originFiles =>",originFiles);
    });

    const newFiles = document.getElementById("file").files = dataTransfer.files;
    
    removeTarget.remove();
    // 업로드할 이미지 갯수 갱신
    const fileButton = document.getElementById("fileButton");
    fileButton.innerHTML = `업로드(${newFiles.length}/10)`;

    if(newFiles.length == 0){
        const preview = document.getElementById("preview");
        const para = document.createElement('p');
        para.textContent = "이미지 없음";
        preview.appendChild(para);
    }

 }
