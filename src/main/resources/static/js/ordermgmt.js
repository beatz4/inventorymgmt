

class OrderMgmt {

    constructor(config) {

        this.config = {
            grid: config.grid
        };

        this.initGrid();
    }

    initGrid() {

        const grid = new tui.Grid({
            el: document.getElementById(this.config.grid), // 컨테이너 엘리먼트
            columns: [ 
                // ...,
            ],
        // ...,
        });
    }
}