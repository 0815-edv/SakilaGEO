#pragma checksum "C:\Users\flori\OneDrive\Programmierung\Zusammenarbeit\SakilaGEO\Frontend\WebFrontend\WebFrontend\Shared\TableTemplate.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "d74acfa0d3647a4e4cb921d69ff727cd54afdd4d"
// <auto-generated/>
#pragma warning disable 1591
namespace WebFrontend.Shared
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "C:\Users\flori\OneDrive\Programmierung\Zusammenarbeit\SakilaGEO\Frontend\WebFrontend\WebFrontend\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\flori\OneDrive\Programmierung\Zusammenarbeit\SakilaGEO\Frontend\WebFrontend\WebFrontend\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\flori\OneDrive\Programmierung\Zusammenarbeit\SakilaGEO\Frontend\WebFrontend\WebFrontend\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\flori\OneDrive\Programmierung\Zusammenarbeit\SakilaGEO\Frontend\WebFrontend\WebFrontend\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\flori\OneDrive\Programmierung\Zusammenarbeit\SakilaGEO\Frontend\WebFrontend\WebFrontend\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\flori\OneDrive\Programmierung\Zusammenarbeit\SakilaGEO\Frontend\WebFrontend\WebFrontend\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\flori\OneDrive\Programmierung\Zusammenarbeit\SakilaGEO\Frontend\WebFrontend\WebFrontend\_Imports.razor"
using Microsoft.AspNetCore.Components.Web.Virtualization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\flori\OneDrive\Programmierung\Zusammenarbeit\SakilaGEO\Frontend\WebFrontend\WebFrontend\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\flori\OneDrive\Programmierung\Zusammenarbeit\SakilaGEO\Frontend\WebFrontend\WebFrontend\_Imports.razor"
using WebFrontend;

#line default
#line hidden
#nullable disable
#nullable restore
#line 10 "C:\Users\flori\OneDrive\Programmierung\Zusammenarbeit\SakilaGEO\Frontend\WebFrontend\WebFrontend\_Imports.razor"
using WebFrontend.Shared;

#line default
#line hidden
#nullable disable
    public partial class TableTemplate<TItem> : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
            __builder.OpenElement(0, "table");
            __builder.AddAttribute(1, "class", "table");
            __builder.OpenElement(2, "thead");
            __builder.OpenElement(3, "tr");
            __builder.AddContent(4, 
#nullable restore
#line 5 "C:\Users\flori\OneDrive\Programmierung\Zusammenarbeit\SakilaGEO\Frontend\WebFrontend\WebFrontend\Shared\TableTemplate.razor"
             TableHeader

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(5, "\r\n    ");
            __builder.OpenElement(6, "tbody");
#nullable restore
#line 8 "C:\Users\flori\OneDrive\Programmierung\Zusammenarbeit\SakilaGEO\Frontend\WebFrontend\WebFrontend\Shared\TableTemplate.razor"
         foreach (var item in Items)
        {

#line default
#line hidden
#nullable disable
            __builder.OpenElement(7, "tr");
            __builder.AddContent(8, 
#nullable restore
#line 10 "C:\Users\flori\OneDrive\Programmierung\Zusammenarbeit\SakilaGEO\Frontend\WebFrontend\WebFrontend\Shared\TableTemplate.razor"
                 RowTemplate(item)

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
#nullable restore
#line 11 "C:\Users\flori\OneDrive\Programmierung\Zusammenarbeit\SakilaGEO\Frontend\WebFrontend\WebFrontend\Shared\TableTemplate.razor"
        }

#line default
#line hidden
#nullable disable
            __builder.CloseElement();
            __builder.CloseElement();
        }
        #pragma warning restore 1998
#nullable restore
#line 15 "C:\Users\flori\OneDrive\Programmierung\Zusammenarbeit\SakilaGEO\Frontend\WebFrontend\WebFrontend\Shared\TableTemplate.razor"
       
    [Parameter]
    public RenderFragment TableHeader { get; set; }

    [Parameter]
    public RenderFragment<TItem> RowTemplate { get; set; }

    [Parameter]
    public IReadOnlyList<TItem> Items { get; set; }

#line default
#line hidden
#nullable disable
    }
}
#pragma warning restore 1591
