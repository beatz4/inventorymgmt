

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

    add(data, doneFunc) {

        let self = this;

        $.ajax({
            type: "POST",
            url: "/companymgmt/add",
            data: data,
            success: function(res) {
                alert("저장되었습니다.");
                $('#popupAddCompay').modal('toggle');
                self.loadData();
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                alert("저장에 실패하였습니다.");
            }
        })
        .done(function(data, textStatus, xhr) {
            //if (doneFunc.clas)
            doneFunc();
        });
        ;
    }

    delete() {
        let self = this;

        const seqs = self.grid.getCheckedRows().map(x => x.seq);

        if (seqs.length === 0) {
            alert("삭제할 업체를 선택해주십시오.");
            return;
        }

        if( confirm("삭제하시겠습니까?") ) {
            $.ajax({
                type: "POST",
                url: "/companymgmt/delete?seqs=" + seqs,
                success: function(res) {
                    alert("삭제되었습니다.");
                    self.loadData();
                },
                error: function(XMLHttpRequest, textStatus, errorThrown){
                    alert("삭제 실패하였습니다.");
                }
            });
        }
    }
}