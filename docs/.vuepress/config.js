module.exports = {
    title: 'ZCP Guide',
    description: 'Documentation of CI/CD, Logging, Monitoring',
    base: '/sam-zcp-lab/',
    searchMaxSuggestions: 10,
    markdown: {
        config: md => {
            md.use(require('markdown-it-anchor'));
            md.use(require('markdown-it-table-of-contents'), {
                "includeLevel": [1, 2, 3]
            });
        },
        lineNumbers: true
    },
    themeConfig: {
        repo: 'cnpst/sam-zcp-lab',
        editLinks: true,
        lastUpdated: 'Last Updated',
        docsDir: 'docs',
        nav: [
            { text: 'Home', link: '/' },
            { text: 'CICD', link: '/cicd/' },
            { text: 'Hands-On', link: '/handson/step01' },
            { text: 'Logging', link: '/logging/' },
            { text: 'Monitoring', link: '/monitoring/' }
        ],
        sidebar: [
            {
                title: 'CICD',
                collapsable: true,
                children:[
                    '/cicd/',
                    '/cicd/strategies'
                ]
            },
            {
                title: 'CI/CD Hands-On',
                collapsable: true,
                children:[
                    '/handson/step01',
                    '/handson/step02',
                    '/handson/step03',
                    '/handson/step04',
                ]
            },
            {
                title: 'Logging',
                collapsable: true,
                children:[
                    '/logging/',
                    '/logging/handson',
                ]
            },
            {
                title: 'Monitoring',
                collapsable: true,
                children:[
                    '/monitoring/',
                    '/monitoring/handson',
                ]
            }
        ]
    }
}
