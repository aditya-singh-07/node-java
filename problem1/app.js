const fs = require('fs');
const path = require('path');
const dir = path.join(__dirname, 'datajson');
const MAXSIZE="200"
let finaljson = { "strikers": [] };
const read_directory = async dir =>
    fs.readdirSync(dir).reduce((finaljson, file) => {
        filePath = path.join(dir, file);
        let content = require(filePath);
        finaljson.strikers = finaljson.strikers.concat(content.strikers);
   
        return finaljson;
    }, {"strikers": [] });

read_directory(dir).then(data => {
    fs.writeFileSync('./final.json', JSON.stringify(data));
});
setTimeout(() =>{
    var stats = fs.statSync("final.json")
    var fileSizeInBytes = stats.size;
    console.log("MAX FILE SIZE ALLOWED IS 200 BYTES")
    console.log(fileSizeInBytes)
    if(fileSizeInBytes > MAXSIZE){
        console.log("File size is more not allowed")
        fs.unlinkSync("final.json")
    }
},2000)


