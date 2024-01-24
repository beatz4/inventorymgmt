
const initGrid = () => {
    const grid = tui.grid;

    grid.applyTheme('default', {
        cell: {
            normal: {
                border: 'black'
            },
            header: {
                background: 'gray',
                text: 'white'
            },
            evenRow: {
                background: '#fee'
            }
        }
    });

    const sampleGrid = new grid({
        el: document.getElementById('grid'),
        scrollX: true,
        scrollY: true,
        draggable: false,
        header: { height: 30 },
        bodyHeight: 200,
        contextMenu: null,
        columns: [
            {
                header: '날짜',
                name: 'date',
                align: "center",
                width: 150,
                whiteSpace: 'normal',
                formatter: function(e) {
                    return e.value
                },
            },
            {
                header: '이름',
                name: 'name',
                align: "left",
                width: 100,
                whiteSpace: 'normal',
                formatter: function(e) {
                    return e.value
                },
            },
            {
                header: '위치',
                name: 'location',
                align: "left",
                width: 150,
                whiteSpace: 'normal',
                formatter: function(e) {
                    return e.value
                },
            },
        ]
    })
}

window.onload = () => {
    const createdGrid = initGrid();

    // 샘플
    const sampleData = [
        {
            date: '2022-12-04',
            name: '석봉팔',
            location: '부산'
        }
    ];

    createdGrid.resetData(sampleData);
}