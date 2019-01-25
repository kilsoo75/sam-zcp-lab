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
        repo: 'myguddy/sam-vuepressy',
        editLinks: true,
        lastUpdated: 'Last Updated',
        nav: [
            { text: 'Home', link: '/' },
            { text: 'CICD', link: '/cicd/' },
            { text: 'Logging', link: '/logging/' },
            { text: 'Monitoring', link: '/monitoring/' }
        ],
        sidebar: {
            '/cicd/':[
                'info', 
                'architecture',
                'hands-on'           
            ],
            '/': [
                ''
            ],
        }
    }
}