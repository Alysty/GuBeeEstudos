import { Directive,HostListener,  HostBinding, ElementRef, Renderer2} from '@angular/core';

@Directive({
  selector: '[appHighlightMouse]'
})
export class HighlightMouseDirective {

  @HostListener('mouseenter') onMouseIsOver(){
    this.backgroundColor = 'black'
  }
  @HostListener('mouseleave') onMouseIsNotOver(){
    this.backgroundColor = 'yellow'
  }

  @HostBinding('style.backgroundColor') backgroundColor: string = 'white';
  constructor() {

  }

}
