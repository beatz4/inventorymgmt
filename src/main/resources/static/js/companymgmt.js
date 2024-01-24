

class CompanyMgmt {

    constructor(config) {

        this.config = {
            grid: config.grid,
            columns: config.columns
        };

        this.grid = this.initGrid();
        this.loadData();
    }

    initGrid() {

        const grid = new tui.Grid({
            el: document.getElementById(this.config.grid),
            rowHeaders: ['checkbox'],
            scrollX: false,
            scrollY: false,
            draggable: false,
            header: { height: 30 },
            bodyHeight: 200,
            contextMenu: null,
            columns: this.config.columns
        });

        return grid;
    }

    loadData() {
        
        let self = this;
        let param = {};

        $.ajax({
            type: "GET",
            url: "/companymgmt/list",
            data: param,
            success: function(res) {
                console.log(res);

                self.grid.resetData(res);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                alert("통신 실패.");
            }
        });
    }
}