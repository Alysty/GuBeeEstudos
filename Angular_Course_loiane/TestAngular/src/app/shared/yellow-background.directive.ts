import { Directive, ElementRef , Renderer2} from '@angular/core';

@Directive({
  selector: '[appYellowBackground]'
})
export class YellowBackgroundDirective {

  constructor(private elementRef: ElementRef, private renderer:Renderer2) {
    elementRef.nativeElement.style.backgroundColor = 'yellow';
    renderer.setStyle(this.elementRef.nativeElement,'background-color', 'yellow')
  }

}
