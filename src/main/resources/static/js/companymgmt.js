

class CompanyMgmt {

    constructor(config) {

        this.config = {
            grid: config.grid,
            columns: config.columns
        };

        this.grid = this.initGrid();
        this.loadData();
        this.addGridEvent();
    }

    initGrid() {

        const grid = new tui.Grid({
            el: document.getElementById(this.config.grid),
            rowHeaders: ['checkbox'],
            scrollX: true,
            scrollY: true,
            draggable: false,
            header: { height: 30 },
            bodyHeight: 200,
            contextMenu: null,
            columns: this.config.columns,
            pageOptions: {
                useClient: true,
                type: 'scroll',
                perPage: 50
            }
        });

        return grid;
    }

    addGridEvent() {

        this.grid.on('dblclick', () => {

            const selectedData = this.grid.getRow(this.grid.getFocusedCell().rowKey);
            
            $('#popupAddCompay').modal('toggle');

            $('#company_seq').val(selectedData.seq);
            $('#company_name').val(selectedData.name);
            $('#company_code').val(selectedData.code);
            $('#company_email').val(selectedData.email);
            $('#company_phone').val(selectedData.phone);

            $('#zipcode').val(selectedData.address.zipcode);
            $('#roadAddress').val(selectedData.address.roadAddress);
            $('#jibunAddress').val(selectedData.address.jibunAddress);
            $('#detailAddress').val(selectedData.address.detailAddress);
            $('#extraAddress').val(selectedData.address.extraAddress);
        });
    }

    loadData() {
        
        let self = this;
        let param = {};

        $.ajax({
            type: "GET",
            url: "/companymgmt/list",
            data: param,
            success: function(res) {
                self.grid.resetData(
                    res
                );
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                alert("데이터 로드에 실패하였습니다.");
            }
        });
    }

    save(data) {

        let self = this;

        $.ajax({
            type: "POST",
            url: "/companymgmt/save",
            data: data,
            success: function(res) {
                alert("저장되었습니다.");
                $('#popupAddCompay').modal('toggle');
                self.loadData();
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                alert("저장에 실패하였습니다.");
            }
        });
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

    search(data) {
        let self = this;

        $.ajax({
            type: "GET",
            url: "/companymgmt/list/search",
            data: data,
            success: function(res) {
                self.grid.resetData(res);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                alert("검색 실패하였습니다.");
            }
        });
    }
}