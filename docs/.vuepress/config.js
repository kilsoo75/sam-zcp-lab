module.exports = {
    title: 'ZCP Guide',
    description: 'Documentation of CI/CD, Logging, Monitoring',
    base: '/sam-k8s-lab/',
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
        repo: 'myguddy/sam-k8s-lab',
        editLinks: true,
        lastUpdated: 'Last Updated',
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
                title: 'Hands-On',
                collapsable: true,
                children:[
                    '/handson/step01',
                ]
            },
            {
                title: 'Logging',
                collapsable: true,
                children:[
                    '/cicd/hands-on'
                ]
            },
            {
                title: 'Monitoring',
                collapsable: true,
                children:[
                    '/cicd/hands-on'
                ]
            }
        ]
    }
}
