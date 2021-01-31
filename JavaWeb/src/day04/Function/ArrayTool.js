var tool = new ArrayTool();
function ArrayTool() {
    //找最大值
    this.getMax = function (arr) {
        var max = arr[0];
        for (var i = 0; i <arr.length ; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }

        return max;
    }

}