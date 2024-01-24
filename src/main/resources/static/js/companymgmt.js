

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
                self.grid.resetData(res);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                alert("데이터 로드에 실패하였습니다.");
            }
        });
    }

    add(data) {

        let self = this;

        $.ajax({
            type: "POST",
            url: "/companymgmt/add",
            data: data,
            success: function(res) {
                
                self.loadData();
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                alert("저장에 실패하였습니다.");
            }
        });
    }
}